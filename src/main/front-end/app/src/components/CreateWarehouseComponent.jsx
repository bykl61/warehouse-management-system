import React, { Component } from 'react';
import WarehouseService from '../service/WarehouseService';

class CreateWarehouseComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            name: '',
            code: ''
        }
        this.changeCodeHandler = this.changeCodeHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.saveWarehouse = this.saveWarehouse.bind(this);
    }

saveWarehouse = (e) => {
    e.preventDefault();

    let warehouse = {name:this.state.name,
        code:this.state.code};
        console.log("Warehouse => " +JSON.stringify(warehouse));

        WarehouseService.createWarehouse(warehouse).then(res => {
            this.props.history.push("/warehouses");

        });
}


changeNameHandler = (event) =>{
    this.setState({name:event.target.value});
}

changeCodeHandler = (event) =>{
    this.setState({code:event.target.value});
}

cancel(){
    this.props.history.push("/warehouse");
}
    render() {
        return (
            <div>
                <div className= "container">
                    <div className= "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add Warehouse</h3>
                            <div className = "card-body">
                                <form> 
                                    <div className="form-group">
                                        <label>Name</label>
                                        <input placeholder="Name" name="name" className="form-control"
                                        value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Code</label>
                                        <input placeholder="Code" name="code" className="form-control"
                                        value={this.state.code} onChange={this.changeCodeHandler}/>
                                    </div>

                                        <button className="btn btn-success col-md  " onClick={this.saveWarehouse}>Save</button>
                                        <button className="btn btn-danger col-md mt-1" onClick={this.cancel.bind(this)}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateWarehouseComponent;