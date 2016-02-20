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
    public partial class BranchesForm : Form
    {
        SqlConnection sqlDBConnection = new SqlConnection();

        public BranchesForm()
        {
            InitializeComponent();
        }

        private void BranchesForm_Load(object sender, EventArgs e)
        {
            sqlDBConnection.ConnectionString = ConfigurationManager.ConnectionStrings["BankDBConnection"].ConnectionString;

            sqlDBConnection.Open();

            LoadBranches();
        }

        private void LoadBranches()
        {
            SqlCommand cmd = sqlDBConnection.CreateCommand();
            cmd.CommandText = "Select BranchName From Branches";

            SqlDataReader reader = cmd.ExecuteReader();

            while(reader.Read())
            {
                comboBranches.Items.Add(reader[0].ToString());
            }

            reader.Close();
        }

        private void comboBranches_SelectedIndexChanged(object sender, EventArgs e)
        {

            SqlCommand cmd = sqlDBConnection.CreateCommand();
            cmd.CommandText = "Select * From Accounts WHERE Branch = '" + comboBranches.Text + "'";

            SqlDataReader reader = cmd.ExecuteReader();

            DataTable table = new DataTable();
            table.Load(reader);

            dataGridView1.DataSource = table;

            reader.Close();

        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = sqlDBConnection.CreateCommand();
            //cmd.CommandText = "Select * From Accounts WHERE Branch = '" + txtBranch.Text + "'"; //Subject to SQL injection Attack

            cmd.CommandText = "Select * From Accounts WHERE Branch = @branch";
            cmd.Parameters.Add("@branch", SqlDbType.NVarChar);
            cmd.Parameters["@branch"].Value = txtBranch.Text;


           


            SqlDataReader reader = cmd.ExecuteReader();

            DataTable table = new DataTable();
            table.Load(reader);

            dataGridView1.DataSource = table;

            reader.Close();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = sqlDBConnection.CreateCommand();
            cmd.CommandText = @"INSERT INTO Branches
                                VALUES (@branchName, @branchAddress, @contactNumber)";

            cmd.Parameters.Add("@branchName", SqlDbType.NVarChar);
            cmd.Parameters.Add("@branchAddress", SqlDbType.NVarChar);
            cmd.Parameters.Add("@contactNumber", SqlDbType.NVarChar);


            cmd.Parameters["@branchName"].Value = txtBranchName.Text;
            cmd.Parameters["@branchAddress"].Value = txtBranchAddress.Text;
            cmd.Parameters["@contactNumber"].Value = txtContactNumber.Text;


            try
            {
                cmd.ExecuteNonQuery();
                MessageBox.Show("1 Record Added");
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
       
    }
}
