import axios from 'axios';

const WAREHOUSE_API_BASE_URL = "http://localhost:8080/warehouses";

class WarehouseService {

    getWarehouse(){
        return axios.get(WAREHOUSE_API_BASE_URL);
    }

    createWarehouse(warehouse){
        return axios.post(WAREHOUSE_API_BASE_URL,warehouse);
    }

    getWarehouseById(id){
        let getID = axios.get(WAREHOUSE_API_BASE_URL + "/" + id);
        console.log(getID);
        return getID;
    }

    updateWarehouse(warehouse,id){
        let update =  axios.put(WAREHOUSE_API_BASE_URL+"/"+id,warehouse)
        console.log(update);
        return update;
    }

    deleteWarehouse(id){
        let delte = axios.delete(WAREHOUSE_API_BASE_URL+"/"+id);
        console.log(delte);
        return delte;
    }

}   

export default new WarehouseService()