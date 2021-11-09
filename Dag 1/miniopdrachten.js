function opdracht1(inputId) {
    var str = document.getElementById(inputId).value;
    if(str=='hallo') {
        alert('Welkom');
    }
    else if(str=='doei') {
        alert('Tot de volgende keer');
    }
}


function opdracht2_3(inputId1, inputId2) {
    var woord = document.getElementById(inputId1).value.toLowerCase();
    var letter = document.getElementById(inputId2).value.toLowerCase();

    if(letter.length != 1) {
        alert('Je moet 1 letter invoeren in het tweede invoervak!');
    }

    else {
        if(woord.includes(letter)) {
            var letterCount = 0;
            var woordTemp = woord;
            var counter = 0;

            while(true) {
                var letterIndex = woordTemp.indexOf(letter);
                if (letterIndex == -1) {
                    break
                }
                letterCount += 1;
                woordTemp = woordTemp.substring(letterIndex + 1, woordTemp.length);
            }
            
            alert('De letter ' + letter + ' zit ' + letterCount + ' keer in ' + woord + '.');
        }
    }
}


var buttonClicks = {A:0, B:0, C:0, D:0};

function opdracht4_5(ev) {
    if(ev.target.id == "A") {
        if(buttonClicks.A > 0) {
            alert('U heeft al ' + buttonClicks.A + ' keer op A geklikt.')
        } 
        buttonClicks.A += 1;
    }
    else if (ev.target.id == "B") {
        if(buttonClicks.B > 0) {
            alert('U heeft al ' + buttonClicks.B + ' keer op B geklikt.')
        } 
        buttonClicks.B += 1;
    }
    else if (ev.target.id == "C") {
        if(buttonClicks.C > 0) {
            alert('U heeft al ' + buttonClicks.C + ' keer op C geklikt.')
        } 
        buttonClicks.C += 1;
    }
    else if (ev.target.id == "D") {
        if(buttonClicks.D > 0) {
            alert('U heeft al ' + buttonClicks.D + ' keer op D geklikt.')
        } 
        buttonClicks.D += 1;
    }
    document.getElementById("div1").innerHTML += ("U heeft op knop " + ev.target.id + " geklikt." + '<br>');
}


var seasonsImgs = ["https://www.hdwallpapers.in/download/moraine_lake_in_winter_canada-1920x1200.jpg",
                   "http://getwallpapers.com/wallpaper/full/f/6/3/1021023-best-spring-meadow-wallpaper-1920x1200.jpg",
                   "https://www.achensee.com/wp-content/uploads/2019/07/Indian_Summer_am_Achensee-Seeberg%C2%A9AchenseeTourismus.jpg",
                   "https://www.desicomments.com/wp-content/uploads/2017/02/Nice-Image-Of-Autumn.jpg"];
var seasonCountA = 0;
var seasonCountB = 0;

function opdracht6_7(ev) {
    if(ev.target.id == "buttonA") {
        seasonCountA += 1;
        let seasonRem = seasonCountA % 4;
        document.getElementById("seasonImgA").src = seasonsImgs[seasonRem];
        document.getElementById("spanA").innerHTML = parseInt(seasonCountA / 4);
    }
    else if(ev.target.id == "buttonB") {
        seasonCountB += 1;
        let seasonRem = seasonCountB % 4;
        document.getElementById("seasonImgB").src = seasonsImgs[seasonRem];
        document.getElementById("spanB").innerHTML = parseInt(seasonCountB / 4);
    }
    else if(ev.target.id == "buttonC") {
        if(document.getElementById("seasonImgA").src == document.getElementById("seasonImgB").src) {
            console.log("HETZELFDE");
        }
        else {
            console.log("NIET HETZELFDE");
        }
    }
}


var seasonCountC = 0;

function opdracht8() {
    seasonCountC += 1;
    let seasonRem = seasonCountC % 4;
    document.getElementById("seasonImgC").src = seasonsImgs[seasonRem];

    if (seasonRem == 1) {
        document.getElementById("imgLambs").hidden = false;
    }
    else {
        document.getElementById("imgLambs").hidden = true;
    }
}