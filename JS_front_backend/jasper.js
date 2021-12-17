const testPrint = () => {
  console.log('test');
};

const test2 = (func, times) => {
  for (let i = 0; i < times; i++) {
    func();
  }
};

test2(testPrint, 5);

// async await

const coffeeBreak = async () => {
  await new Promise((resolve) => {
    setTimeout(resolve, 10);
  });
  console.log('walked down');

  const makeCoffee = new Promise((resolve) => {
    setTimeout(resolve, 2000);
  }).then(() => console.log('Coffee ready'));

  const toiletBreak = new Promise((resolve) => {
    setTimeout(resolve, 5000);
  }).then(() => console.log('Bladder empty'));

  await Promise.all([makeCoffee, toiletBreak]);
  console.log('Coffee ready and bladder empty');
  console.log('break done');
};

coffeeBreak();
