import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientModel } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-patient-add',
  templateUrl: './patient-add.component.html',
  styleUrls: ['./patient-add.component.css']
})
export class PatientAddComponent implements OnInit {

	patient = new PatientModel;

  constructor(private patientService: PatientService, private router: Router) { }

  ngOnInit(): void {
  }
  onSubmit(){
	this.patientService.createPatient(this.patient).subscribe({
		next: (res) => {
			if(res){
				alert("Patient created successfully")
				this.patient = new PatientModel();
				this.router.navigate(["admin/patient-add"]);
			}
		},
		error: (err) => {
			alert("something went wrong");
		}
	})
  }

}
