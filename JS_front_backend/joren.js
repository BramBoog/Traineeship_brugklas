console.log('Hello, World!');

/**
 * - Fetch API
 * - Promises (async/await)
 * - Callbacks
 */

// function doSomething2 () {
//   console.log('do something');
// };

// let count = 0;

// const doSomething = function (param) {
//   count++;
//   console.log('do something', count);
// };

// const doSomething3 = (param) => {
//   console.log('do something');
// }

// const anotherFunction = (func, number) => {
//   if (number > 3) {
//     func();
//   }
// };

// anotherFunction(doSomething, 2);

// setTimeout(doSomething, 1000);

// setInterval(doSomething, 1000);

/**
 * Accept a callback, call the callback only if Time since Epoch is even number
 * const d = new Date();
 * const seconds = Math.round(d.getTime() / 1000);
 */
// const arr = [1, 2, 3];

// for (let i = 0; i < arr.length; i++) {
//   console.log(arr[i]);
// }

// const arrIterator = (item, index, ar) => {
//   console.log(item);
// };

// arr.forEach((item, index, ar) => {
//   console.log(item);
// });

// 0 5 2 4 6 1 3

// console.log('hello 0');

// setTimeout(() => {
//   console.log('hello 1');
// }, 0);

// Promise.resolve().then(() => {
//   console.log('hello 2');
// });

// setTimeout(() => {
//   console.log('hello 3');
// }, 0);

// Promise.resolve().then(() => {
//   console.log('hello 4');
// });

// console.log('hello 5');

// Promise.resolve().then(() => {
//   console.log('hello 6');
// });

// const prom = new Promise((resolve, reject) => {
//   setTimeout(() => {
//     resolve(new Promise());
//   }, 500);
// });

// prom
//   .then((val) => {
//     console.log(val);
//   })
//   .catch((reason) => {
//     console.log(reason);
//   })
//   .finally(() => {});

const morningRoutine = () => {
  const wakeup = new Promise((res, rej) => {
    setTimeout(res, 500);
  });

  wakeup
    .then(() => {
      console.log('wakeup done');

      return new Promise((resolve) => {
        setTimeout(resolve, 1000);
      });
    })
    .then(() => {
      console.log('shower done!!');
    });
};
// morningRoutine();

const fetchTodos = async () => {
  const response = await fetch('/todos');
  const result = await response.json();

  const { data } = result;
  data.forEach((todo) => {
    const p = document.createElement('p');
    p.innerText = todo.name;
    document.body.appendChild(p);
  });
};
fetchTodos();

const deleteTodo = async () => {
  const response = await fetch('/todos/4', {
    method: 'DELETE',
  });
  const result = await response.json();
  fetchTodos();
};
deleteTodo();

const updateTodo = async () => {
  const response = await fetch('/todos/3', {
    method: 'PUT',
    body: JSON.stringify({ name: 'Do something else blabla' }),
    headers: {
      'Content-Type': 'application/json',
    },
  });
  const result = await response.json();
  fetchTodos();
};
updateTodo();

// const postTodo = async () => {
//   const response = await fetch('/todos', {
//     method: 'POST',
//     body: JSON.stringify({ name: 'Create new one' }),
//     headers: {
//       'Content-Type': 'application/json',
//     },
//   });
//   const result = await response.json();
// };
// postTodo();
