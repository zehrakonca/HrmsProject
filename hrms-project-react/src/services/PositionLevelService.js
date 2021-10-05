import axios from "axios";

export default class PositionLevelService{
    urlBase = "http://localhost:8080/api/positionLevels";

    getAllPositionLevels(){
        return axios.get("http://localhost:8080/api/positionLevels/getAll");
    }
}