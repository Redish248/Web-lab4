import React, { Component } from 'react';

class Point extends Component{
    render() {
        return (
            <tr>
                <td>{this.props.point.x}</td>
                <td>{this.props.point.y}</td>
                <td>{this.props.point.r}</td>
                <td>{this.props.point.inInArea}</td>
            </tr>
        )
    }
}

export default Point;