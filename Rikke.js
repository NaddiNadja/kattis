const sc = require("readline").createInterface({
  input: process.stdin,
});

const candies = [];

sc.on("line", (input) => {
  const [candy, price] = input.split(" ");
  candies.push({ c: candy, p: price });
});
