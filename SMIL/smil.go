package main

import (
	"fmt"
)

func main() {
	var inp string
	fmt.Scanln(&inp)
	var indices []int
	for i := 0; i < len(inp); i++ {
		if string(inp[i]) == ";" || string(inp[i]) == ":" {
			if i+2 < len(inp) {
				if string(inp[i+1]) == "-" {
					if string(inp[i+2]) == ")" && i+2 < len(inp) {
						indices = append(indices, i)
					}
				}
			}
			if i+1 < len(inp) {
				if string(inp[i+1]) == ")" && i+1 < len(inp) {
					indices = append(indices, i)
				}
			}
		}
	}
	for i := 0; i < len(indices); i++ {
		fmt.Println(indices[i])
	}
}
