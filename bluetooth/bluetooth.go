package main

import (
	"fmt"
)

func main() {
	var n int
	fmt.Scanln(&n)

	left, right := true, true
	tl, bl, tr, br := 8, 8, 8, 8

	for i := 0; i < n; i++ {
		var tooth, con string
		fmt.Scanln(&tooth, &con)
		if string(tooth[0]) == "+" {
			// top left
			if con == "b" {
				left = false
			} else {
				tl--
			}
		} else if string(tooth[0]) == "-" {
			// bottom left
			if con == "b" {
				left = false
			} else {
				bl--
			}
		} else {
			if string(tooth[1]) == "+" {
				// top right
				if con == "b" {
					right = false
				} else {
					tr--
				}
			} else if string(tooth[1]) == "-" {
				// bottom right
				if con == "b" {
					right = false
				} else {
					br--
				}
			}
		}
	}
	if tl == 0 || bl == 0 {
		left = false
	}
	if tr == 0 || br == 0 {
		right = false
	}

	if left {
		fmt.Println("0")
	} else if right {
		fmt.Println("1")
	} else {
		fmt.Println("2")
	}
}
