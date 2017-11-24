import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component'; //Composant principal
import { LoginComponent } from './login/login.component'; //Composant enfant
import { AccueilComponent } from './accueil/accueil.component';

//Implémente les composantes d'animations
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
//Importer FormsModule permet d'utiliser les erreurs sur l'input de l'adresse mail
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material';
import { MatButtonModule } from '@angular/material/button';



//Import bibliothèques pour un tableau
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {HttpModule} from '@angular/http';
import {CdkTableModule} from '@angular/cdk/table';
import {
  MatSortModule,
  MatTableModule,
  MatTabsModule
} from '@angular/material';

const routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },//Pas de segment.
  { path: 'login', component : LoginComponent },
  { path: 'accueil', component : AccueilComponent }
  // { path: 'skill_validation', component : SkillValidationComponent },
  // { path: 'skill_management', component : SkillManagementComponent },
  // { path: 'collaborator_management', component : CollaboratorManagementComponent },
  // { path: 'settings', component : SettingsComponent },
  // { path: '**', component : NotFoundComponent }//Segment introuvable dans les routes.
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AccueilComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    //Pour le tableau
    MatSortModule,
    MatTableModule,
    MatTabsModule,

    RouterModule.forRoot(routes)//On passe au module de routage notre tableau de routes pour qu'il puisse appeller les components enfant en fonction de l'url.
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
