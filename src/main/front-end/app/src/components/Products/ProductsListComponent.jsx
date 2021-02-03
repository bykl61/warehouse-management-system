import React, { Component } from 'react';
import ProductSevice from '../../service/ProductSevice';

class ProductsListComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            products:[]
        }
        this.addProduct = this.addProduct.bind(this);
        this.editProduct = this.editProduct.bind(this);
    }

deletedProduct(id){
    ProductSevice.deleteProduct(id).then(res => {
        this.setState({products:this.state.products
            .filter(product => product.id !==id)})
        });
}

  
editProduct(id){
    this.props.history.push('/update-product/'+id);
}

componentDidMount(){

   ProductSevice.getProduct().then(response => 
    this.setState({products:Object.values(response.data)[0]})
   )
}

addProduct(){
    this.props.history.push("/add-product");
}


    render() {
        return (
            <div>
                <h2 className="text-center">Product List</h2>
                <div className = "row">
                    <button className="btn btn-primary" onClick={this.addProduct} style={{marginBottom:"5px"}}>Add Product</button>
                </div>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Code</th>
                                    <th>Vat Rate</th>
                                    <th>Vat Amount</th>
                                    <th>Price</th>
                                    <th>Total Price</th>
                                    <th>Created Date</th>
                                    <th>Updated Date</th>
                                    <th>Status</th>
                                    <th>Action</th>
           
                                </tr>
                            </thead>

                            <tbody>
                                {
                                    this.state.products.map(
                                        product => 
                                        <tr key = {product.id}>
                                            
                                            <td>{product.name}</td>
                                            <td>{product.code}</td>
                                            <td>{product.vatRate}</td>
                                            <td>{product.vatAmount}</td>
                                            <td>{product.price}</td>
                                            <td>{product.vatIncludedPrice}</td>
                                            <td>{product.createdDate}</td>
                                            <td>{product.updatedDate}</td>
                                            <td>{product.status}</td>
                                            <td>
                                                <button onClick = {() => this.editProduct(product.id)} className="btn btn-info">Update</button>
                                                <button onClick = {() => this.deletedProduct(product.id)} className="btn btn-danger" style={{marginLeft:"3px"}}>Delete</button>
                                                <button onClick = {() => this.viewProduct(product.id)} className="btn btn-info" style={{marginTop:"3px"}}>View</button>
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

export default ProductsListComponent;