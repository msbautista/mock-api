import axios from 'axios';

const BASE_URL = process.env.VUE_APP_BASE_URL;

export default class EndpointApi {

    createEndpoint(endpoint) {
        return axios.post(`${BASE_URL}/addEndpoint`, endpoint, {
            headers: {
                'Content-Type': 'application/json'
            }
        })
    }

}
