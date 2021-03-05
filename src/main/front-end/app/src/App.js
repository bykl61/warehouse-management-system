import React from 'react';
import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom';
import WarehouseListComponents from './components/WarehouseListComponents';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateWarehouseComponent from './components/CreateWarehouseComponent';
import UpdateWarehouseComponent from './components/UpdateWarehouseComponent';
import ProductsListComponent from './components/Products/ProductsListComponent';
import CreateProductComponent from './components/Products/CreateProductComponent';
import UpdateProductComponents from './components/Products/UpdateProductComponents';
import LoginUserComponent from './components/users/LoginUserComponent';
function App() {
  return (
    
    <div>
        <Router>
           
                <HeaderComponent/>
                  <div className= "container">
                     <Switch>
                         <Route path = "/login"  component={LoginUserComponent}></Route>
                       <Route path = "/" exact component={LoginUserComponent}></Route>
                       <Route path = "/warehouses" component={WarehouseListComponents}></Route>
                       <Route path = "/add-warehouse" component={CreateWarehouseComponent}></Route>
                       <Route path = "/update-warehouse/:id" component={UpdateWarehouseComponent}></Route>
                       <Route path = "/products" component={ProductsListComponent}></Route>
                       <Route path = "/add-product" component={CreateProductComponent}></Route>
                       <Route path = "/update-product/:id" component={UpdateProductComponents}></Route>

                      </Switch>
                   </div>
                
              
        </Router>
    </div>
  );
}

export default App;
