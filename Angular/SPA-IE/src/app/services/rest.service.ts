import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class RestService {
    private _url = 'http://localhost:8080/spa_war/api';

    constructor(private http: HttpClient) { }

    getProvinces() {
        return this.http.get(this._url + '/province/');
    }

    getCantos(id: number) {
        return this.http.get(this._url + '/canton/ByProvince/' + id);
    }

    getDistricts(id: number) {
        return this.http.get(this._url + '/district/ByCanton/' + id);
    }

}