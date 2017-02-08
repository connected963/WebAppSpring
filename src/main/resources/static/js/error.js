/**
 * Created by connected on 2/7/17.
 */
$(document).ready(function () {
    $(".errorImage").click(function () {
        changeBackground();
        changeLabelsColors();
    })
});


function changeBackground() {
    $(".errorBackground").css("backgroundColor", "rgb(" + Math.floor((Math.random() * 255) + 1) + ", " + Math.floor((Math.random() * 255) + 1) + ", " + Math.floor((Math.random() * 255) + 1) + ")");
}

function changeLabelsColors() {
    var color1 = Math.floor((Math.random() * 255) + 1);
    var color2 = Math.floor((Math.random() * 255) + 1);
    var color3 = Math.floor((Math.random() * 255) + 1);

    $(".errorMessage").css("color", "rgb(" + color1 + ", " + color2 + ", " + color3 + ")");
    $(".errorCode").css("color", "rgb(" + color1 + ", " + color2 + ", " + color3 + ")");
    $(".errorDate").css("color", "rgb(" + color1 + ", " + color2 + ", " + color3 + ")");
}
