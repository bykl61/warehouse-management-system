import axios from 'axios';
import React, { Component } from 'react';



const LOGIN_API_BASE_URL = "http://localhost:8080/login";

class LoginService extends Component {
    postLogin(user){
        let login = axios.post(LOGIN_API_BASE_URL,user);
        console.log(login);
        return login;
    }
}

export default new LoginService();