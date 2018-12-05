<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Вход</title>
</head>
<body>
    <div id="app"> </div>

    <script type="text/babel">
        // рендеринг элемента
        import React from 'react';
        import ReactDOM from 'react-dom';
        ReactDOM.render(
            <h1>Hello React</h1>,  // элемент, который мы хотим создать
            document.getElementById("app")    // где мы этот элемент хотим создать
        )
    </script>
</body>
</html>
