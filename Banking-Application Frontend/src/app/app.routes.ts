
import { Routes } from '@angular/router';
import { LoginComponent } from './auth/components/login/login.component';
import { SignupComponent } from './auth/components/signup/signup.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { AccountComponent } from './components/accounts/accounts.component';
import { CustomerComponent } from './components/cutomers/cutomers.component';
import { PaymentComponent } from './components/payments/payments.component';
import { TransactionListComponent } from './components/transactions/transactions.component';


export const routes: Routes = [

    {
        path:"",component:HomeComponentComponent
    },
    {
        path:"login",component:LoginComponent
    },
    {
        path:"signup",component:SignupComponent
    }
    ,
    {
        path:"admin",loadChildren: () => import("./modules/admin/admin.module").then(m => m.AdminModule)
    },
    {
        path:"user",loadChildren: () => import("./modules/user/user.module").then(m => m.UserModule)
    },
    {
        path:"accounts", component: AccountComponent
    },
    {
        path:"customers", component: CustomerComponent
    },
    {
        path:"payments", component: PaymentComponent
    },
    {
        path:"transactions", component: TransactionListComponent
    }
]
