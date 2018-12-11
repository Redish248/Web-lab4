import axios from 'axios';
import {DataTable} from 'primereact/datatable';
import {Column} from "primereact/column";
import React, { Component } from 'react';

class DataTablePoint extends Component {

    constructor() {
        super();
        this.state = {
            points: []
        };
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/checkPoint/points`)
            .then(res => {
                const points = res.data;
                this.setState({ points });
            })
    }

    render() {
        return (
            <DataTable value={this.state.points}>
                <Column field="x" header="X" />
                <Column field="y" header="Y" />
                <Column field="r" header="R" />
                <Column field="isInArea" header="Hit" />
            </DataTable>
        );
    }
}

export default DataTablePoint;