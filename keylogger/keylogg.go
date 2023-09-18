package main

import (
	"fmt"
	"strings"
)

func main() {
	var n int
	fmt.Scanln(&n)

	out := make([]string, n)
	index := 0

	caps := false

	for i := 0; i < n; i++ {
		var inp string
		fmt.Scanln(&inp)
		if inp == "bump" || inp == "dink" || inp == "thumb" {
			caps = !caps
		} else if inp == "pop" && index != 0 {
			index--
		} else {
			out[index] = getKey(caps, inp)
			index++
		}
	}

	for i := 0; i < index; i++ {
		fmt.Print(out[i])
	}
	fmt.Print("\n")
}

func getKey(caps bool, sound string) string {
	var out string
	switch s := sound; s {
	case "clank":
		out = "a"
	case "bong":
		out = "b"
	case "click":
		out = "c"
	case "tap":
		out = "d"
	case "poing":
		out = "e"
	case "clonk":
		out = "f"
	case "clack":
		out = "g"
	case "ping":
		out = "h"
	case "tip":
		out = "i"
	case "cloing":
		out = "j"
	case "tic":
		out = "k"
	case "cling":
		out = "l"
	case "bing":
		out = "m"
	case "pong":
		out = "n"
	case "clang":
		out = "o"
	case "pang":
		out = "p"
	case "clong":
		out = "q"
	case "tac":
		out = "r"
	case "boing":
		out = "s"
	case "boink":
		out = "t"
	case "cloink":
		out = "u"
	case "rattle":
		out = "v"
	case "clock":
		out = "w"
	case "toc":
		out = "x"
	case "clink":
		out = "y"
	case "tuc":
		out = "z"
	case "whack":
		out = " "
	}
	if caps {
		out = strings.ToUpper(out)
	}
	return out
}
