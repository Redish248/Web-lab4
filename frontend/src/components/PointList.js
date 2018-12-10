import React, { Component } from 'react';
import Point from './Point';

class PointList extends Component{
    render() {
        const points = this.props.points.map(point =>
            <Point key={point._links.self.href} point={point}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Hit</th>
                </tr>
                {points}
                </tbody>
            </table>
        )
    }
}

export default PointList;