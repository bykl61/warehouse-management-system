import React, { Component } from 'react';

class HeaderComponent extends Component {
    render() {
        return (
            <div>
               <header>
                    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
                        <div><a href="/login" className="navbar-brand">WarehouseAPI</a></div>
                        <div><a href="/warehouses" className="navbar-brand">Warehouses</a></div>
                        <div><a href="/products" className="navbar-brand">Products</a></div>
                    </nav>
               </header>
            </div>
        );
    }
}

export default HeaderComponent;