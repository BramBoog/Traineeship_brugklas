// console.log('Hello, World!');

// const test = () => {
//   console.log('hello world');
// };

// const anotherfunc = (func, condition = true) => {
//   if (condition) {
//     func();
//   }
// };
// anotherfunc(test);

const morningRoutine = () => {
  const wakeup = new Promise((resolve) => {
    setTimeout(resolve, 500);
  });

  wakeup
    .then(() => {
      console.log('wakeup done');

      const wekkerUit = new Promise((resolve) => {
        setTimeout(resolve, 10);
      });

      const bedUit = new Promise((resolve) => {
        setTimeout(resolve, 500);
      });

      Promise.all([wekkerUit, bedUit]).then(() => {
        console.log('wekker uit en uit bed');
      });
    })
    .then(() => {
      console.log('testmultitask');
      console.log('shower done!!');
    });
};
morningRoutine();
