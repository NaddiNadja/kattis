package main

import (
	"fmt"
)

func main() {
	var jon, doctor string
	fmt.Scanln(&jon)
	fmt.Scanln(&doctor)
	if len(doctor) > len(jon) {
		fmt.Println("no")
	} else {
		fmt.Println("go")
	}
}
