import axios from "axios";

export default class WorkTypeService{
    urlBase = "http://localhost:8080/api/workTypes";

    getAllWorkTypes(){
        return axios.get("http://localhost:8080/api/workTypes/getAll");
    }


}