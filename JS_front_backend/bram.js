console.log('Hello, World!');

// const main = (func, lst) => {
//   const rand_num = Math.floor(Math.random() * lst.length);
//   func(lst[rand_num]);
// };

// function do_smth_str(str) {
//   const str2 = str + '!';
//   console.log(str2);
// }

// const test_lst = ['hey', 'hello', 'yo'];
// main(do_smth_str, test_lst);

const morningRoutine = () => {
  const wakeUp = new Promise((res) => {
    setTimeout(res, 500);
  });

  wakeUp
    .then(() => {
      console.log('Rise and shine');

      const makeCoffee = new Promise((res) => {
        setTimeout(res, 1000);
      });

      const shower = new Promise((res) => {
        setTimeout(res, 5000);
      });

      return Promise.all([makeCoffee, shower]).then(() => {
        console.log('Clean and coffee made.');
      });
    })
    .then(() => {
      console.log('All ready');
    });
};
