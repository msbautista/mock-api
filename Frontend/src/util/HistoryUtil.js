let MOCKAPI_HISTORY_KEY = "mockapi-history";
let HISTORY_LIMIT = 10;

export default class HistoryUtil {

    getHistoryFromLocalStorage() {
        let mockapiHistory = localStorage.getItem(MOCKAPI_HISTORY_KEY);
        if (mockapiHistory == null) {
            return [];
        } else {
            let mockapiHistoryJSON = JSON.parse(mockapiHistory);
            return mockapiHistoryJSON.requests;
        }
    }

    addRequestToHistory(endpoint) {
        let mockaApiHistory = this.getHistoryFromLocalStorage();
        if(mockaApiHistory.length > HISTORY_LIMIT){
            mockaApiHistory = mockaApiHistory.slice(0, HISTORY_LIMIT)
        }
        mockaApiHistory.unshift({ ...endpoint })
        localStorage.setItem(MOCKAPI_HISTORY_KEY, JSON.stringify({ requests: mockaApiHistory }))
    }

}
