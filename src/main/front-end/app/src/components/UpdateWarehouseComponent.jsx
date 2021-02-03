import React, { Component } from 'react';
import WarehouseService from '../service/WarehouseService';

class UpdateWarehouseComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            id:this.props.match.params.id,
            name: '',
            code: '',
            status:''
        }
        this.changeCodeHandler = this.changeCodeHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.updateWarehouse = this.updateWarehouse.bind(this);
    }

    updateWarehouse = (e) => {
    e.preventDefault();

    let warehouse = {name:this.state.name,
        code:this.state.code,
        status:this.state.status};
        console.log("Warehouse => " +JSON.stringify(warehouse));
        WarehouseService.updateWarehouse(warehouse,this.state.id).then(res =>{
            this.props.history.push("/warehouses");
        });
        
       
}
componentDidMount(){
    WarehouseService.getWarehouseById(this.state.id).then((res) =>{
        let warehouse = res.data;
        console.log(warehouse)
        this.setState({name:warehouse.name,code:warehouse.code,
        status:warehouse.status})
    });
}

changeNameHandler = (event) =>{
    this.setState({name:event.target.value});
}

changeCodeHandler = (event) =>{
    this.setState({code:event.target.value});
}

changeStatusHandler = (event) =>{
    this.setState({status:event.target.value});
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
                            <h3 className="text-center">Update Warehouse</h3>
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
                                    <div className="form-group">
                                        <label>Status</label>
                                        <input placeholder="Status" name="status" className="form-control"
                                        value={this.state.status} onChange={this.changeStatusHandler}/>
                                    </div>

                                        <button className="btn btn-success col-md  " onClick={this.updateWarehouse}>Update</button>
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


export default UpdateWarehouseComponent;