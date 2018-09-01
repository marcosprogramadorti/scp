

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule}    from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';



import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {AccordionModule} from       'primeng/accordion';
import {InputTextModule } from     'primeng/inputtext';
import {RadioButtonModule} from     'primeng/radiobutton';
import {ButtonModule} from          'primeng/button';
import {SplitButtonModule} from 'primeng/splitbutton';
import {CalendarModule} from 'primeng/calendar';
import {DropdownModule} from 'primeng/dropdown';
import {TabViewModule} from 'primeng/tabview';
import {ToastModule} from 'primeng/toast';
import {CodeHighlighterModule} from 'primeng/codeHighlighter';
import {TableModule} from 'primeng/table';
import {DialogModule} from 'primeng/dialog';
import {InputSwitchModule} from 'primeng/inputswitch';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {AutoCompleteModule} from 'primeng/autocomplete';
import {InputMaskModule} from 'primeng/inputmask';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {MultiSelectModule} from 'primeng/multiselect';







import { FormPessoaComponent } from './form-pessoa/form-pessoa.component';
import { DocumentoComponent } from './documento/documento.component';
import { TelefoneComponent } from './telefone/telefone.component';
import { PessoaEnderecoComponent } from './pessoa-endereco/pessoa-endereco.component';
import { EmailComponent } from './email/email.component';
import { ExperienciaComponent } from './experiencia/experiencia.component';
import { PesquisaPessoaComponent } from './pesquisa-pessoa/pesquisa-pessoa.component';






@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    InputTextModule,
    AccordionModule,
    RadioButtonModule,
    ButtonModule,
    SplitButtonModule,
    CalendarModule,
    DropdownModule,
    TabViewModule,
    ToastModule,
    CodeHighlighterModule,
    TableModule,
    BrowserAnimationsModule,
    DialogModule,
    InputSwitchModule,
    HttpClientModule,
    ReactiveFormsModule,
    MessagesModule,
    MessageModule,
    AutoCompleteModule,
    InputMaskModule,
    InputTextareaModule,
    MultiSelectModule
    
    
    
    
  ],
  declarations: [FormPessoaComponent,  DocumentoComponent, TelefoneComponent, PessoaEnderecoComponent, EmailComponent, ExperienciaComponent, PesquisaPessoaComponent ],
  exports: [
    FormPessoaComponent,
    PesquisaPessoaComponent
    
    
  ]
})
export class PessoaModule { }
