using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using System.Data.SqlClient;
using System.Configuration;




namespace SimpleConnectedMode
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            
        }
        SqlConnection sqlDBConnection = new SqlConnection();

        private void Form1_Load(object sender, EventArgs e)
        {
            
            sqlDBConnection.ConnectionString = ConfigurationManager.ConnectionStrings["BankDBConnection"].ConnectionString;

            sqlDBConnection.Open();

        }

        private void btn_Load_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = sqlDBConnection.CreateCommand();

            cmd.CommandText = "SELECT AccountNo FROM Accounts";

            SqlDataReader reader = cmd.ExecuteReader();

            while (reader.Read())
            {
                comboAccountNo.Items.Add(reader[0].ToString());
            }

            reader.Close();

        }

        private void comboAccountNo_SelectedIndexChanged(object sender, EventArgs e)
        {
            SqlCommand cmd = sqlDBConnection.CreateCommand();

            cmd.CommandText = @"SELECT * 
                                FROM Accounts 
                                WHERE AccountNo = " + comboAccountNo.Text;

            SqlDataReader reader = cmd.ExecuteReader();

            if (reader.Read())
            {
                txtHolderName.Text = reader[1].ToString();
                txtBranch.Text = reader[2].ToString();
                txtOpenDate.Text = reader[3].ToString();
                txtBalance.Text = reader[4].ToString();  
            }

            reader.Close();


        }

        private void btnBranches_Click(object sender, EventArgs e)
        {
            BranchesForm frm = new BranchesForm();
            frm.ShowDialog();
        }
                
    }
}
