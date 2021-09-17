import React from 'react'
import { Grid, Image, Form, Button,Header,Icon} from 'semantic-ui-react'
import connection from '../../img/connection.jpg';
import './SignupEmployer.css';

export default function Signup() {
    return (
        <div>
            <Header as='h2' disabled dividing>
                <Icon name='suitcase' />
                <Header.Content>Sign up and find employee!</Header.Content>
            </Header>
            <Grid>
                <Grid.Column width={7}>
                    <Image src={connection} centered className="main"></Image>
                </Grid.Column>
                <Grid.Column width={7} centered>
                    <Form>
                        <Form.Group widths='equal'>
                            <Form.Input
                                fluid
                                label='first name'
                                placeholder='First name'
                            />
                            <Form.Input
                                fluid
                                label='last name'
                                placeholder='Last name'
                            />
                        </Form.Group>
                        <Form.Input
                            label='email'
                            placeholder='Please enter your email address'
                        />
                        <Form.Group widths='equal'>
                            <Form.Input
                                fluid
                                label='password'
                                placeholder='your passsword'
                            />
                            <Form.Input
                                fluid
                                label='password repeat'
                                placeholder='your password'
                            />
                        </Form.Group>
                        <Form.Input
                            label='telephone'
                            placeholder='Please enter your telephone number'
                        />
                        <Form.Input
                            label='company name'
                            placeholder='Please enter your company name'
                        />
                        <Form.Input
                            label='web address'
                            placeholder='Please enter your company web address'
                        />
                        <Form.Checkbox label='I agree to the Terms and Conditions' />
                        <Button color="teal">Sign Up</Button>
                    </Form>
                </Grid.Column>
            </Grid>
        </div>
    )
}
