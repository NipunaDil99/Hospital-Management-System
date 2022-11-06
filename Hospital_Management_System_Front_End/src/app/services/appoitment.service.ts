import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Appointment } from '../models/appointment.model';

@Injectable({
  providedIn: 'root'
})
export class AppoitmentService {
  private _baseUrl = 'http://localhost:4200/api/v1/appointment/';

  constructor(private http: HttpClient) { }

  create(appointment : Appointment) {
    return this.http.post(`${this._baseUrl}/saveAppoitment`,appointment, {responseType: 'text'})
  }
}
