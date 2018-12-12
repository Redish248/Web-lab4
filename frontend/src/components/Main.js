import React, { Component } from 'react';

class Main extends Component {
    render() {
        return (
            //Как оно должно выглядеть?
            <div>
                <div className="container">
                    <table className="mainTable">
                        <tr>
                            <td>
                                <div id="canvasPoint">
                                </div>
                            </td>
                            <td>
                                <div id = "inputXYR"/>
                            </td>
                        </tr>
                    </table>
                </div>
                <div id="resultPoint"/>
            </div>
        );
    }
}

export default Main;