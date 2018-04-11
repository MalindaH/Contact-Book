/**
 * Name: Linhui Huang (Malinda)
 * Course: CS30S
 * Teacher: Mr. Hardman
 * Lab #2, Program #1
 * Date Last Modified: 4/10/2018
 */
package commalindah.httpsgithub.contactbook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static Contact[] contactsArray;
    private static int numContactsAdded;

    private EditText mNameInput;
    private EditText mPhoneInput;
    private EditText mEmailInput;
    private TextView mErrorMessage;
    private TextView mSortedList;

    String name;
    String phone;
    String email;

    private int insertionSteps = 0;
    private int selectionSteps = 0;
    private int quickSteps = 0;

    @Override
    /**
     * onCreate is the method that is run when we create an instance of this activity
     *
     * @param savedInstanceState is a Bundle object that allows the Activity to restore
     *                           itself to a previously saved instance
     * @return Nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameInput = (EditText) findViewById(R.id.et_name);
        mPhoneInput = (EditText) findViewById(R.id.et_phone);
        mEmailInput = (EditText) findViewById(R.id.et_email);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);
        mSortedList = (TextView) findViewById(R.id.tv_sorted_lists);

        contactsArray = new Contact[50];
        numContactsAdded = 0;
    }

    /**
     * addContact adds a new contact to the array of contacts we will need to sort
     *
     * @param vw is the View that is related to this method
     * @return Nothing is returned
     */
    public void addContact(View vw)
    {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        Contact contact;

        if (mNameInput.getText().toString() == "")
        {
            mErrorMessage.setText("You must enter at least a name to add a contact.");
        }
        else
        {
            if (numContactsAdded >= contactsArray.length)
            {
                mErrorMessage.setText("You cannot add any more contacts to this contact book.");
            }
            else
            {
                name = mNameInput.getText().toString();
                phone = mPhoneInput.getText().toString();
                email = mEmailInput.getText().toString();

                contact = new Contact(name, phone, email);
                contactsArray[numContactsAdded] = contact;
                numContactsAdded += 1;

                mNameInput.setText("");
                mPhoneInput.setText("");
                mEmailInput.setText("");

                if (inputManager != null)
                {
                    inputManager.hideSoftInputFromWindow(vw.getApplicationWindowToken(), 0);
                }

                mErrorMessage.setText("The contact was successfully added.");
            }
        }
    }

    /**
     * sortContacts sorts the contacts that the user entered and displays them in order of their names
     *
     * @param vw is the View that is related to this method
     * @return Nothing is returned
     */
    public void sortContacts( View vw )
    {
        String sortedList = "";

        //insertionSort();
        //selectionSort();
        quickSort( contactsArray, 0, numContactsAdded - 1);

        for( int i = 0; i < numContactsAdded; i++ )
        {
            if( contactsArray != null)
            {
                sortedList += String.format("Name: %15s\nPhone: %15s\nE-mail: %15s\n\n", contactsArray[i].getName(), contactsArray[i].getPhone(), contactsArray[i].getEmail() );
            }
        }

        mErrorMessage.setText("");
        mSortedList.setText(sortedList);
    }

    /**
     * insertionSort uses the Insertion Sort algorithm to sort the contacts' names in ascending order
     *
     * @param "" There are no parameters
     * @return Nothing is returned
     */
    private void insertionSort()
    {
        Contact key;
        int j;

        for( int i = 1; i < numContactsAdded; i++)
        {
            key = contactsArray[i];
            j = i - 1;

            while( j >= 0 && ( contactsArray[j].getName() ).compareTo(key.getName()) > 0 )
            {
                contactsArray[j+1] = contactsArray[j];
                j = j - 1;
            }

            contactsArray[j+1] = key;
        }
    }

    /**
     * insertionSort uses the Selection Sort algorithm to sort the contacts' names in ascending order
     *
     * @param "" There are no parameters
     * @return Nothing is returned
     */
    private void selectionSort()
    {
        int minIndex;
        Contact temp;

        for( int i = 0; i < numContactsAdded - 1; i++ )
        {
            minIndex = i;

            for( int j = i+1; j < numContactsAdded; j++)
            {
                if( ( contactsArray[j].getName() ).compareTo(contactsArray[minIndex].getName()) < 0)
                {
                    minIndex = j;
                }
            }

            temp = contactsArray[minIndex];
            contactsArray[minIndex] = contactsArray[i];
            contactsArray[i] = temp;
        }

    }

    /**
     * quickSort uses the Quick Sort algorithm to sort a list of contacts in an ascending order of their names
     *
     * @param low is the beginning index of the section of the array we would like to sort
     * @param high is the ending index of the section of the array we would like to sort
     * @return Nothing is returned
     */
    private void quickSort( Contact[] contactsArray, int low, int high )
    {
        int middle;
        int i;
        int j;

        Contact pivot;
        Contact temp;

        if( low < high )
        {
            middle = low + (high-low)/2;
            pivot = contactsArray[middle];
            i = low;
            j = high;

            while( i <= j )
            {
                while( (contactsArray[i].getName() ).compareTo(pivot.getName()) < 0 )
                {
                    i++;
                }

                while( (contactsArray[i].getName() ).compareTo(pivot.getName()) > 0 )
                {
                    j--;
                }

                if( i <= j )
                {
                    temp = contactsArray[i];
                    contactsArray[i] = contactsArray[j];
                    contactsArray[j] = temp;
                    i++;
                    j--;
                }
            }

            if( low < j )
            {
                quickSort( contactsArray, low, j );
            }

            if( high > i )
            {
                quickSort( contactsArray, i, high );
            }
        }
    }
}















