#include <iostream>
#include <unordered_map>
#include <vector>
#include <queue>
#include <set>
#include <string>
#include <sstream>
#include <algorithm>
#include <climits>

using namespace std;

using Graph = unordered_map<string, unordered_map<string, int>>;

int n, g, t;
vector<pair<string, vector<string>>> ns;
vector<tuple<string, int, vector<string>>> gs, ts;

string source = "source";
string terminal = "terminal";

// Helper function to split a string by spaces
vector<string> split(const string &s) {
    vector<string> tokens;
    stringstream ss(s);
    string token;
    while (ss >> token) {
        tokens.push_back(token);
    }
    return tokens;
}

Graph buildNetworkGraph() {
    Graph adj_graph;

    for (const auto &[gname, gnum, gall] : gs) {
        adj_graph[source][gname] = gnum;
        for (const auto &[nname, nall] : ns) {
            if (all_of(gall.begin(), gall.end(), [&](const string &x) { return find(nall.begin(), nall.end(), x) == nall.end(); })) {
                adj_graph[gname][nname + "s"] = 10;
            }
        }
    }

    for (const auto &[nname, nall] : ns) {
        adj_graph[nname + "s"][nname] = 1;
    }

    for (const auto &[tname, tnum, tall] : ts) {
        adj_graph[tname][terminal] = tnum;
        for (const auto &[nname, nall] : ns) {
            if (all_of(tall.begin(), tall.end(), [&](const string &x) { return find(nall.begin(), nall.end(), x) == nall.end(); })) {
                adj_graph[nname][tname] = 10;
            }
        }
    }

    return adj_graph;
}

pair<vector<string>, int> dfs(const Graph &graph, const string &fr, const string &to) {
    deque<tuple<vector<string>, int, string>> stack;
    set<string> visited;

    stack.push_back({{fr}, INT_MAX, fr});
    visited.insert(fr);

    while (!stack.empty()) {
        auto [path, min_flow, u] = stack.front();
        stack.pop_front();

        for (const auto &[v, capacity] : graph.at(u)) {
            if (visited.find(v) == visited.end() && capacity > 0) {
                visited.insert(v);
                auto new_path = path;
                new_path.push_back(v);
                int new_min_flow = min(min_flow, capacity);
                if (v == to) {
                    return {new_path, new_min_flow};
                }
                stack.push_back({new_path, new_min_flow, v});
            }
        }
    }

    return {{}, 0};
}

int fordFulkerson(Graph &graph, const string &source, const string &sink) {
    int maxflow = 0;

    while (true) {
        auto [path, minflow] = dfs(graph, source, sink);
        if (path.empty()) {
            return maxflow;
        }

        maxflow += minflow;

        for (size_t i = 0; i < path.size() - 1; ++i) {
            const string &fr = path[i];
            const string &to = path[i + 1];
            graph[fr][to] -= minflow;

            if (fr != source && to != sink) {
                if (graph[to].find(fr) != graph[to].end()) {
                    graph[to][fr] += minflow;
                } else {
                    graph[to][fr] = minflow;
                }
            }
        }
    }
}

int main() {
    // Input and parsing
    cin >> n;
    cin.ignore();
    for (int i = 0; i < n; ++i) {
        string line;
        getline(cin, line);
        auto inp = split(line);
        string nname = inp[0];
        vector<string> nall(inp.begin() + 2, inp.end());
        ns.emplace_back(nname, nall);
    }

    cin >> g;
    cin.ignore();
    for (int i = 0; i < g; ++i) {
        string line;
        getline(cin, line);
        auto inp = split(line);
        string gname = inp[0];
        int gnum = stoi(inp[1]);
        vector<string> gall(inp.begin() + 3, inp.end());
        gs.emplace_back(gname, gnum, gall);
    }

    cin >> t;
    cin.ignore();
    for (int i = 0; i < t; ++i) {
        string line;
        getline(cin, line);
        auto inp = split(line);
        string tname = inp[0];
        int tnum = stoi(inp[1]);
        vector<string> tall(inp.begin() + 3, inp.end());
        ts.emplace_back(tname, tnum, tall);
    }

    // Build graph
    Graph networkGraph = buildNetworkGraph();

    // Calculate max flow
    cout << fordFulkerson(networkGraph, source, terminal) << endl;

    return 0;
}
