import React from 'react'
import { Grid, Form, Button, Image,Header,Icon } from 'semantic-ui-react'
import meeting from '../../img/meeting3.jpg';

export default function SignupJobSeeker() {
    return (
        <div>
            <Header as='h2' disabled dividing>
                <Icon name='lab' />
                <Header.Content>Sign up and join us!</Header.Content>
            </Header>
            <Grid>
                <Grid.Column width={8} centered>
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
                            label='national identity'
                            placeholder='Please enter your national identity'
                        />
                        <Form.Input
                            label='date'
                            placeholder='Please enter your date'
                        />
                        <Form.Checkbox label='I agree to the Terms and Conditions' />
                        <Button color="teal">Sign Up</Button>
                    </Form>
                </Grid.Column>
                <Grid.Column width={8}>
                    <Image src={meeting} centered className="main"></Image>
                </Grid.Column>
            </Grid>
        </div>
    )
}
