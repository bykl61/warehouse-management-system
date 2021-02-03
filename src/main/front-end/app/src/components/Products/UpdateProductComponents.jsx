import React, { Component } from 'react';
import ProductSevice from '../../service/ProductSevice';

class UpdateProductComponents extends Component {
    constructor(props){
        super(props)

        this.state = {
            id:this.props.match.params.id,
            name: '',
            code: '',
            vatRate:'',
            vatAmount:'',
            price:'',
            vatIncludedPrice:'',
            status:''
        }
        this.changeCodeHandler = this.changeCodeHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changePriceHandler = this.changePriceHandler.bind(this);
        this.changeVatAmountHandler = this.changeVatAmountHandler.bind(this);
        this.changeVatRateHandler = this.changeVatRateHandler.bind(this);
        this.changevatIncludedPriceHandler = this.changevatIncludedPriceHandler.bind(this);
        this.changeStatusHandler = this.changeStatusHandler.bind(this);
        this.updateProduct = this.updateProduct.bind(this);
    }

    updateProduct = (e) => {
    e.preventDefault();

    let product = {name:this.state.name,
        code:this.state.code,
        vatRate:this.state.vatRate,
        vatAmount:this.state.vatAmount,
        price:this.state.price,
        vatIncludedPrice:this.state.vatIncludedPrice
    };
        console.log("Product => " +JSON.stringify(product));

        ProductSevice.updateProduct(product,this.state.id).then(res => {
            this.props.history.push("/products");

        });
}
componentDidMount(){
    ProductSevice.getProductById(this.state.id).then((res) =>{
        let product = res.data;
        console.log(product)
        this.setState({name:product.name,code:product.code,
        vatAmount:product.vatAmount,vatIncludedPrice:product.vatIncludedPrice,
        vatRate:product.vatRate,price:product.price,
        status:product.status})
    });
}

changeNameHandler = (event) =>{
    this.setState({name:event.target.value});
}

changeCodeHandler = (event) =>{
    this.setState({code:event.target.value});
}

changePriceHandler = (event) =>{
    this.setState({price:event.target.value});
}

changeVatAmountHandler = (event) =>{
    this.setState({vatAmount:event.target.value});
}

changeVatRateHandler = (event) =>{
    this.setState({vatRate:event.target.value});
}

changevatIncludedPriceHandler = (event) =>{
    this.setState({vatIncludedPrice:event.target.value});
}

changeStatusHandler = (event) =>{
    this.setState({status:event.target.value});
}

cancel(){
    this.props.history.push("/product");
}
    render() {
        return (
            <div>
                <div className= "container">
                    <div className= "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            <h3 className="text-center">Add Product</h3>
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
                                        <label>Vat Rate</label>
                                        <input placeholder="VAT RATE" name="vatRate" className="form-control"
                                        value={this.state.vatRate} onChange={this.changeVatRateHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Vat Amount</label>
                                        <input placeholder="Vat Amount" name="vatAmount" className="form-control"
                                        value={this.state.vatAmount} onChange={this.changeVatAmountHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Price</label>
                                        <input placeholder="Price" name="price" className="form-control"
                                        value={this.state.price} onChange={this.changePriceHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Vat Included Price</label>
                                        <input placeholder="Vat Included Price" name="vatIncludedPrice" className="form-control"
                                        value={this.state.vatIncludedPrice} onChange={this.changevatIncludedPriceHandler}/>
                                    </div>
                                    <div className="form-group">
                                        <label>Status</label>
                                        <input placeholder="Status" name="status" className="form-control"
                                        value={this.state.status} onChange={this.changeStatusHandler}/>
                                    </div>

                                        <button className="btn btn-success col-md  " onClick={this.updateProduct}>Update</button>
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

export default UpdateProductComponents;