import axios from 'axios';

const PRODUCT_API_BASE_URL = "http://localhost:8080/products";

class ProductService {

    getProduct(){
        return axios.get(PRODUCT_API_BASE_URL);
    }

    createProduct(product){
        return axios.post(PRODUCT_API_BASE_URL,product);
    }

    getProductById(id){
        let getID = axios.get(PRODUCT_API_BASE_URL + "/" + id);
        console.log(getID);
        return getID;
    }

    updateProduct(product,id){
        let update =  axios.put(PRODUCT_API_BASE_URL+"/"+id,product)
        console.log(update);
        return update;
    }

    deleteProduct(id){
        let delte = axios.delete(PRODUCT_API_BASE_URL+"/"+id);
        console.log(delte);
        return delte;
    }

}   

export default new ProductService()