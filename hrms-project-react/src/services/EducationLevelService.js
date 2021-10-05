import axios from "axios";

export default class EducationLevelService{
    urlBase = "http://localhost:8080/api/educationLevels";

    getAllEducationLevels(){
        return axios.get("http://localhost:8080/api/educationLevels/getAll");
    }
}