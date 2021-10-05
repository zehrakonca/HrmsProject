import axios from "axios";

export default class EmployerService{
    urlBase = "http://localhost:8080/api/employers";

    getAllEmployers(){
        return axios.get("http://localhost:8080/api/employers/getAll");
    }


}