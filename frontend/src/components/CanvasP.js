import React, { Component } from 'react';
import 'primereact/resources/themes/nova-light/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

class CanvasP extends Component {
    constructor(props) {
        super(props);
        this.state = {context: null};
    }

    render() {
        return (
            <canvas id="canvas" width="300px" height="300px"
                    /*ref={(e) => this.setState({context: e.getContext('2d')})} /*onClick={this.clickCanvas.bind(this)}*//>

        );
    }
}

    function clickCanvas() {
        // removeError();
        var r = document.getElementById("R").valueOf();
        var canvas = document.getElementById('canvas');
        var br = canvas.getBoundingClientRect();
        var left = br.left;
        var top = br.top;
        var event = window.event;
        var x = event.clientX - left;
        var y = event.clientY - top;
        alert(x + " " + " " + r);
        var size = canvas.height;
        if (r > 0) {
            x = Math.round((x - size / 2) * r * 10 / 2 / 65) / 10;
            y = Math.round((-y + size / 2) * r * 10 / 2 / 65) / 10;
            drawCanvas(r);
            document.getElementById("X").value = x;
            document.getElementById("Y").value = y;
            drawPoint(x, y, r);
            document.getElementById('pointButton').click();
            // drawAllPoints();
        }
    }


function drawAllPoints() {
    let r = document.getElementById('R').valueOf();
    let x,y;
    let counter=0;
    let table = document.getElementById('resultPoint');
    drawCanvas(r);
    if (!(table===null)) {
        table.querySelectorAll('td').forEach(function (e) {
            switch (counter) {
                case 0:
                    x = e.innerHTML;
                    break;
                case 1:
                    y = e.innerHTML;
                    break;
                case 2:
                    break;
                case 3:
                    drawPoint(x, y, r);
                    counter -= 4;
                    break;
            }
            counter++;
        });
    }
}

//------------canvas-------------

function drawCanvas(r){
    let canvas = document.getElementById('canvas'),
        context = canvas.getContext("2d");
//очистка
    context.clearRect(0, 0, canvas.width, canvas.height);
//треугольник
    context.beginPath();
    context.moveTo(150, 150);
    context.lineTo(150, 85);
    context.lineTo(20,150);
    context.lineTo(150, 150);
    context.closePath();
    context.strokeStyle = "blue";
    context.fillStyle = "blue";
    context.fill();
    context.stroke();

//прямоугольник
    context.beginPath();
    context.rect(150, 150, 65, 130);
    context.closePath();
    context.strokeStyle = "blue";
    context.fillStyle = "blue";
    context.fill();
    context.stroke();

//сектор
    context.beginPath();
    context.moveTo(150, 150);
    context.arc(150, 150, 130, Math.PI*3/2, 0, false);
    context.closePath();
    context.strokeStyle = "blue";
    context.fillStyle = "blue";
    context.fill();
    context.stroke();

//отрисовка осей
    context.beginPath();
    context.font = "12px Verdana";
    context.moveTo(150, 0); context.lineTo(150, 300);
    context.moveTo(150, 0); context.lineTo(145, 12);
    context.moveTo(150, 0); context.lineTo(155, 12);
    context.closePath();
    context.strokeStyle = "black";
    context.fillStyle = "black";
    context.stroke();

    context.beginPath();
    context.fillText("Y", 160, 10);
    context.moveTo(0, 150);
    context.lineTo(300, 150);
    context.moveTo(300, 150);
    context.lineTo(288, 145);
    context.moveTo(300, 150);
    context.lineTo(288, 155);
    context.fillText("X", 290, 135);
    context.closePath();
    context.strokeStyle = "black";
    context.fillStyle = "black";
    context.stroke();

//деления X
    context.beginPath();
    context.moveTo(145, 20);
    context.lineTo(155, 20);
    context.moveTo(145, 85);
    context.lineTo(155, 85);
    context.moveTo(145, 215);
    context.lineTo(155, 215);
    context.moveTo(145, 280);
    context.lineTo(155, 280);
    if (r === 0){
        context.fillText("R", 160, 25);
        context.fillText("R/2", 160, 90);
        context.fillText("-R/2", 160, 220);
        context.fillText("-R", 160, 285);
    } else {
        context.fillText(r, 160, 25);
        context.fillText((r / 2), 160, 90);
        context.fillText(-(r / 2), 160, 220);
        context.fillText(-r, 160, 285);
    }

//деления Y
    context.moveTo(20, 145);
    context.lineTo(20, 155);
    context.moveTo(85, 145);
    context.lineTo(85, 155);
    context.moveTo(215, 145);
    context.lineTo(215, 155);
    context.moveTo(280, 145);
    context.lineTo(280, 155);
    if (r===0){
        context.fillText("-R", 12, 140);
        context.fillText("-R/2", 70, 140);
        context.fillText("R/2", 205, 140);
        context.fillText("R", 275, 140);
    } else {
        context.fillText(-r, 12, 140);
        context.fillText(-(r / 2), 70, 140);
        context.fillText((r / 2), 205, 140);
        context.fillText(r, 275, 140);
    }

    context.closePath();
    context.strokeStyle = "black";
    context.fillStyle = "black";
    context.stroke();
}

function drawPoint(x,y,r){
    let color;
    let canvas = document.getElementById('canvas'),
        ctx = canvas.getContext("2d");
    if (isArea(x,y,r)) {
        color = 'green';
    } else {
        color = 'red';
    }
    ctx.beginPath();
    ctx.arc(150+x*130/r,150-y*130/r,2,0,2*Math.PI);
    ctx.fillStyle = color;
    ctx.fill();
    ctx.closePath();
}

function isArea(x, y, r) {
    if (
        ((x <= 0) && (y >= 0) && (y <= (r+x)/2)) ||
        ((x >= 0) && (y >= 0) && ((x * x + y * y) <= (r * r ))) ||
        ((x >= 0) && (y <= 0) && (x <= r/2) && (y >= -r))
    ) {
        return true;
    }
    return false;

}
window.onload = function() {drawCanvas(2); };

export default CanvasP;