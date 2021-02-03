import React, { Component } from 'react';
import LoginService from '../../service/LoginService';

class LoginUserComponent extends Component {
    constructor(props){
        super(props)
        
        this.state ={
            email:'',
            password:''
        }

        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.loginUser = this.loginUser.bind(this);


    }

    loginUser = (e) => {
        e.preventDefault();
    
        let user = {email:this.state.email,
            password:this.state.password};
            console.log("USER => " +JSON.stringify(user));
           
           LoginService.postLogin(user).then(res => {
            this.props.history.push("/warehouses");
           });
           
    }


    changeEmailHandler = (event) =>{
        this.setState({email:event.target.value});
    }
    
    changePasswordHandler = (event) =>{
        this.setState({password:event.target.value});
    }



    render() {
        return (
            <div>
                <form>
                <h3>Sign In</h3>

                <div className="form-group">
                    <label>Email address</label>
                    <input  name="email" className="form-control" placeholder="Enter email" 
                    value={this.state.email} onChange={this.changeEmailHandler}/>
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input name="password" className="form-control" placeholder="Enter password" 
                    value={this.state.password} onChange={this.changePasswordHandler}/>
                </div>

                

                <button className="btn btn-primary btn-block" onClick={this.loginUser}>Login</button>
            
            </form>
            </div>
        );
    }
}

export default LoginUserComponent;