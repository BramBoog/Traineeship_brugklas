function plus() {
    var waarde1 = document.getElementById('invoer1').value;
    var waarde2 = document.getElementById('invoer2').value;
    var a = Number.parseInt(waarde1);
    var b = Number.parseInt(waarde2);
    var result = a + b;
    document.getElementById('resultaat').textContent='Het resultaat is :'+result;
}

function min() {
    var waarde1 = document.getElementById('invoer1').value;
    var waarde2 = document.getElementById('invoer2').value;
    var a = Number.parseInt(waarde1);
    var b = Number.parseInt(waarde2);
    var result = a - b;
    document.getElementById('resultaat').textContent='Het resultaat is :'+result;
}

function keer() {
    var waarde1 = document.getElementById('invoer1').value;
    var waarde2 = document.getElementById('invoer2').value;
    var a = Number.parseInt(waarde1);
    var b = Number.parseInt(waarde2);
    var result = a * b;
    document.getElementById('resultaat').textContent='Het resultaat is :'+result;
}

function gedeelddoor() {
    var waarde1 = document.getElementById('invoer1').value;
    var waarde2 = document.getElementById('invoer2').value;
    var a = Number.parseInt(waarde1);
    var b = Number.parseInt(waarde2);
    var result = a / b;
    document.getElementById('resultaat').textContent='Het resultaat is :'+result;
}

function checkbox() {
    var staatAanOfNiet = document.getElementById('kaku').checked;
    if (staatAanOfNiet) {
        console.log('Staat aangevinkt');
        console.log('Staat aangevinkt x2')
    } else {
        console.log('Staat niet aangevinkt')
    }
}