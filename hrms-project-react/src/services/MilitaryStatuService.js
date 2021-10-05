import axios from "axios";

export default class MilitaryStatuService{
    urlBase = "http://localhost:8080/api/militaryStatus";

    getAllMilitaryStatu(){
        return axios.get("http://localhost:8080/api/militaryStatus/getAll");
    }


}