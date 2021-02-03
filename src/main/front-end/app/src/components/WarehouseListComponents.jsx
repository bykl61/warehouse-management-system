import React, { Component } from 'react';
import WarehouseService from '../service/WarehouseService';

class WarehouseListComponents extends Component {
    constructor(props){
        super(props)

        this.state = {
            warehouses:[]
        }
        this.addWarehouse = this.addWarehouse.bind(this);
        this.editWarehouse = this.editWarehouse.bind(this);
    }

deletedWarehouse(id){
    WarehouseService.deleteWarehouse(id).then(res => {
        this.setState({warehouses:this.state.warehouses
            .filter(warehouse => warehouse.id !==id)})
        });
}

  
editWarehouse(id){
    this.props.history.push('/update-warehouse/'+id);
}

componentDidMount(){

   WarehouseService.getWarehouse().then(response => 
    this.setState({warehouses:Object.values(response.data)[0]})
   )
}

addWarehouse(){
    this.props.history.push("/add-warehouse");
}


    render() {
        return (
            <div>
                <h2 className="text-center">Warehouse List</h2>
                <div className = "row">
                    <button className="btn btn-primary" onClick={this.addWarehouse} style={{marginBottom:"5px"}}>Add Warehouse</button>
                </div>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Code</th>
                                    <th>Created Date</th>
                                    <th>Updated Date</th>
                                    <th>Status</th>
                                    <th>Action</th>
           
                                </tr>
                            </thead>

                            <tbody>
                                {
                                    this.state.warehouses.map(
                                        warehouse => 
                                        <tr key = {warehouse.id}>
                                            
                                            <td>{warehouse.name}</td>
                                            <td>{warehouse.code}</td>
                                            <td>{warehouse.createdDate}</td>
                                            <td>{warehouse.updatedDate}</td>
                                            <td>{warehouse.status}</td>
                                            <td>
                                                <button onClick = {() => this.editWarehouse(warehouse.id)} className="btn btn-info">Update</button>
                                                <button onClick = {() => this.deletedWarehouse(warehouse.id)} className="btn btn-danger" style={{marginLeft:"5px"}}>Delete</button>
                                            </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                </div>
            </div>
        );
    }
}

export default WarehouseListComponents;