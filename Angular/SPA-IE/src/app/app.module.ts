import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormCourseComponent } from './components/form-course/form-course.component';
import { GridModule } from '@progress/kendo-angular-grid';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StudentListComponent } from './components/student-list/student-list.component';
import { StudentFormComponent } from './components/student-form/student-form.component';
import { ButtonsModule } from '@progress/kendo-angular-buttons';
import { LabelModule } from '@progress/kendo-angular-label';
import { MenuModule } from '@progress/kendo-angular-menu';






const appRoutes: Routes = [
  {
    path: 'form-course',
    component: FormCourseComponent,
    data: { title: 'Course Add' }
  },
  {
    path: 'student-list/:action',
    component: StudentListComponent,
    data: { title: 'Student List' }
  },
  {
    path: 'student-add',
    component: StudentFormComponent,
    data: { title: 'Student Add' }
  },
  {
    path: 'student-update/:idUpdate',
    component: StudentFormComponent,
    data: { title: 'Student Update' }
  },
  {
    path: 'student-detail/:idDetail',
    component: StudentFormComponent,
    data: { title: 'Student Details' }
  }

];

@NgModule({
  declarations: [
    AppComponent,
    //  CourseComponent,
    FormCourseComponent,
    StudentListComponent,
    StudentFormComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    GridModule,
    BrowserAnimationsModule,
    ButtonsModule,
    LabelModule,
    MenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
