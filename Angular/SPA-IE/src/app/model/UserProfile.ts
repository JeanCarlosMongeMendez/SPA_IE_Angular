import { Canton } from './Canton';
import { Province } from './Province';
import { District } from './District';

export class UserProfile{
    idUserProfile: number;
    username: string;
    password: string;
    userPhoto: string;
    interests: string;
    email: string;
    admin: boolean;
    canton: Canton;
    province: Province;
    district: District;
    creationDate: Date;
    enable: boolean;
}