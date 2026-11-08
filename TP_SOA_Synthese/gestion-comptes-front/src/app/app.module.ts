import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UtilisateurListComponent } from './components/utilisateur/utilisateur-list/utilisateur-list.component';
import { UtilisateurFormComponent } from './components/utilisateur/utilisateur-form/utilisateur-form.component';
import { CompteListComponent } from './components/compte/compte-list/compte-list.component';
import { CompteFormComponent } from './components/compte/compte-form/compte-form.component';
import { SoapInfoComponent } from './components/soap/soap-info/soap-info.component';

@NgModule({
  declarations: [
    AppComponent,
    UtilisateurListComponent,
    UtilisateurFormComponent,
    CompteListComponent,
    CompteFormComponent,
    SoapInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
