import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PrescriptionModel } from '../models/prescription.model';

@Injectable({
  providedIn: 'root'
})
export class PrescriptionService {
  private _baseUrl = 'http://hospitalmanagementsystem1-env.eba-k97j3tu3.ap-south-1.elasticbeanstalk.com/api/v1/prescription';

  constructor(private http: HttpClient) { }

  create(prescription : PrescriptionModel) {
    return this.http.post(`${this._baseUrl}/addPrescription`,prescription, {responseType: 'text'});
  }

  getList() {
    return this.http.get<PrescriptionModel[]>(`${this._baseUrl}/getPrescriptions`);
  }

  delete(prescription_id : number) {
    return this.http.delete<string>(`${this._baseUrl}/deletePrescription/`+prescription_id);
  }

  update(prescription_id: number,prescription: PrescriptionModel) {
    return this.http.put<PrescriptionModel>(`${this._baseUrl}/updatePrescription/`+prescription_id,prescription);
  }

  getPrescription(id:any) {
    return this.http.get<PrescriptionModel[]>(`${this._baseUrl}/getPrescription/`+id);
  }
}
