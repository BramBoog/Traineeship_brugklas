console.log('hello world');

// const telAf = () => {
//   console.log(Math.floor((new Date('2021-12-16T14:00:00') - new Date()) / 1000));
// };

// setInterval(telAf, 1000);
// // (new Date('2021-12-17T00:00:00') - new Date()) / 1000

// const doSomething = () => {
//   console.log('tel af:');
// };

// const gebruikFunctie = (func, number) => {
//   if (number < 10) {
//     doSomething;
//     number--;
//   }
// };

// gebruikFunctie(doSomething, 9);

const morningRoutine = () => {
  const wakkerWorden = new Promise((resolve) => {
    setTimeout(resolve, 500);
  });

  const tandenpoetsen = (resolve) => {
    console.log('ik ga tandenpoetsen');
    setTimeout(resolve, 500);
  };

  wakkerWorden
    .then(() => {
      console.log('wakker');
      return new Promise(tandenpoetsen);
    })
    .catch(() => {
      console.log('Verslapen');
    })
    .then(() => {
      console.log('ik ben klaar met tandenpoetsen');
    });

  // wakkerWorden.then(()=>{
  //   console.log("wakker");
  //   return new Promise(func, );
  // }).catch(()=>{
  //     console.log("Verslapen");
  // }).then
};
morningRoutine();
