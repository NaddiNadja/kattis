package main

import (
	"fmt"
	"sort"
)

func main() {
	var n int
	fmt.Scanln(&n)

	inp := make([]int, n)

	for i := 0; i < n; i++ {
		var input int
		fmt.Scan(&input)
		inp[i] = input
	}

	sort.Ints(inp)

	sum := 0

	for i := n - 3; i >= 0; i -= 3 {
		sum += inp[i]
	}

	fmt.Println(sum)
}
